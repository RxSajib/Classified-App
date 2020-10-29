package com.digital.digitalbusinessowners.Register;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.digital.digitalbusinessowners.DataManager;
import com.digital.digitalbusinessowners.HomePage;
import com.digital.digitalbusinessowners.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class OTPPage extends Fragment {

    private String KEY;
    private RelativeLayout loginbuttonID;
    private String CodeInput;
    private String fullotp_code;

    private FirebaseAuth Mauth;
    private PinView pinView;
    private String GetKey, GetPhoneNumber;
    private DatabaseReference MuserDatabase;

    private MaterialTextView timetext;
    private MaterialTextView sendcodeagain;
    private Handler handler = new Handler();
    private boolean is_starttime = false;
    private ProgressDialog Mprogress;

    public OTPPage() {
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.o_t_p_page, container, false);

        Mprogress = new ProgressDialog(getActivity());
        Bundle bundle = getArguments();
        GetKey = bundle.getString("KEY");
        Toast.makeText(getContext(), GetKey, Toast.LENGTH_LONG).show();







        timetext = view.findViewById(R.id.Time);
        sendcodeagain = view.findViewById(R.id.ResentCodeText);


        RunnableInterFace  interFace = new RunnableInterFace();
        new Thread(interFace).start();


        sendcodeagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_starttime){
                    RunnableInterFace  interFace = new RunnableInterFace();
                    new Thread(interFace).start();

                    is_starttime = false;
                    sendcodeagain.setTextColor(getResources().getColor(R.color.carbon_black_54));
                    sendcodeagain.setEnabled(false);
                }
            }
        });


        MuserDatabase = FirebaseDatabase.getInstance().getReference().child(DataManager.UserRoot);
        Mauth = FirebaseAuth.getInstance();

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);




        pinView = view.findViewById(R.id.PinViewID);

        pinView.requestFocus();

        InputMethodManager inputManager = (InputMethodManager) pinView.getContext().getSystemService(getActivity().getApplication().INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(pinView, InputMethodManager.SHOW_IMPLICIT);


        pinView.setAnimationEnable(true);
        pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                CodeInput = s.toString();
                if(CodeInput.length() == 6){




                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(GetKey, CodeInput);
                    signInWithPhoneAuthCredential(credential);




                }
            }
        });






        return view;
    }



    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {



        Mauth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Mprogress.setTitle("Please wait ...");
                            Mprogress.setMessage("wait for a moment setup your account");
                            Mprogress.show();

                            String CurrentUserID = Mauth.getCurrentUser().getUid();
                            Map<String, Object> usemap = new HashMap<>();
                            usemap.put(DataManager.UserPhoneNumber, GetPhoneNumber);

                            MuserDatabase.child(CurrentUserID).updateChildren(usemap)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(getActivity(), "ok", Toast.LENGTH_LONG).show();
                                                Mprogress.dismiss();




                                            }
                                            else {
                                                Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                                Mprogress.dismiss();
                                            }
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Mprogress.dismiss();
                                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                                        }
                                    });



                        } else {

                            Mprogress.dismiss();
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

    @Override
    public void onStart() {

        FirebaseUser Muser = Mauth.getCurrentUser();
        if(Muser != null){

            Intent intent = new Intent(getActivity(), HomePage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }

        super.onStart();
    }




    class RunnableInterFace extends Thread{

        @Override
        public void run() {

            for(int i=59; i>=0; i--){


                final int finalI = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        timetext.setText(Integer.toString(finalI));
                        if(finalI == 0){
                            is_starttime = true;
                            sendcodeagain.setTextColor(getResources().getColor(R.color.carbon_red_600));
                            sendcodeagain.setEnabled(true);
                        }
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}