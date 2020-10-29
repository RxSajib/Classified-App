package com.digital.digitalbusinessowners.Register;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.HomePage;
import com.digital.digitalbusinessowners.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;


public class PhoneLogin extends Fragment {

    private EditText number;
    private RelativeLayout crossbutton;
    private RelativeLayout getotpbutton;
    private CountryCodePicker countryCodePicker;
    private DatabaseReference MuserDatabase;



    private FirebaseAuth Mauth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks Mcallback;
    private PhoneAuthProvider.ForceResendingToken mResentToken;



    private String complected_phone_number;



    public PhoneLogin() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.phone_login, container, false);

        MuserDatabase = FirebaseDatabase.getInstance().getReference().child(DataManager.UserRoot);
        countryCodePicker = view.findViewById(R.id.CountryCodePicker);

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M){
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }
        else {
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.carbon_white));
        }

        number = view.findViewById(R.id.NumberInput);
        countryCodePicker.registerCarrierNumberEditText(number);
        crossbutton = view.findViewById(R.id.CrossButton);

        crossbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(null);
            }
        });


        getotpbutton = view.findViewById(R.id.GetOTPButton);
        getotpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String Number = number.getText().toString().trim();
               if(Number.isEmpty()){

                   MaterialAlertDialogBuilder Mbuilder = new MaterialAlertDialogBuilder(getActivity());
                   Mbuilder.setTitle("Error ");
                   Mbuilder.setMessage("Please enter your valid phone number");
                   Mbuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {

                       }
                   });

                   AlertDialog alertDialog = Mbuilder.create();
                   alertDialog.show();
               }
               else {
                   complected_phone_number = "+"+countryCodePicker.getFullNumber();

                   Toast.makeText(getActivity(), complected_phone_number, Toast.LENGTH_LONG).show();
                   PhoneAuthProvider.getInstance().verifyPhoneNumber(
                           complected_phone_number,
                           60,
                           TimeUnit.SECONDS,
                           getActivity(),
                           Mcallback
                   );

               }



            }
        });



        Mauth = FirebaseAuth.getInstance();


        Mcallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("ERROR", e.getMessage());
                Log.d("ERROR", e.getMessage().toString());
            }

            @Override
            public void onCodeSent( String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);



                goto_otp_page(new OTPPage(), s);



            }
        };

        return view;
    }

    private void goto_otp_page(Fragment fragment, String key){
        if(fragment != null){

            Bundle bundle = new Bundle();
            bundle.putString("KEY", key);
            fragment.setArguments(bundle);
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.MainFrameLayout, fragment).addToBackStack(null);
            transaction.commit();
        }
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        Mauth.signInWithCredential(credential)
                .addOnCompleteListener((Activity) getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                          String UID = Mauth.getCurrentUser().getUid();
                          Map<String, Object> usermap = new HashMap<String, Object>();
                          usermap.put(DataManager.UserPhoneNumber, complected_phone_number);

                          MuserDatabase.child(UID).setValue(usermap)
                                  .addOnCompleteListener(new OnCompleteListener<Void>() {
                                      @Override
                                      public void onComplete(@NonNull Task<Void> task) {
                                          if(task.isSuccessful()){
                                                goto_homepage();
                                          }
                                          else {
                                              Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                          }
                                      }
                                  })
                                  .addOnFailureListener(new OnFailureListener() {
                                      @Override
                                      public void onFailure(@NonNull Exception e) {
                                          Toast.makeText(getActivity(), e.getMessage().toString(), Toast.LENGTH_LONG).show();
                                      }
                                  });

                        } else {


                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                MaterialAlertDialogBuilder Mbuilder = new MaterialAlertDialogBuilder(getActivity());
                                Mbuilder.setTitle("Server Error ...");
                                Mbuilder.setMessage(task.getException().getMessage());

                                Mbuilder.setPositiveButton("TRY AGAIN", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });

                                AlertDialog alertDialog = Mbuilder.create();
                                alertDialog.show();
                            }
                        }
                    }
                });
    }





    private void goto_homepage(){
        Intent intent = new Intent(getActivity(), HomePage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }



}