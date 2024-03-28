package com.example.evcharge.Fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import com.example.evcharge.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    View view;
    ImageButton ibBack,btnEdit,ibUploadProfile;
    CircleImageView ivProfile;
    AppCompatButton btnCancel;
    int SELECT_PICTURE = 200;
    EditText etName,etMobile,etEmail,etPincode,etState,etCity,etTown,etAddress,etAdditionalInf;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        ibBack = view.findViewById(R.id.ibBack);
        ibBack.setOnClickListener(this);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
        btnEdit = view.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(this);
        ibUploadProfile = view.findViewById(R.id.ibUploadProfile);
        ibUploadProfile.setOnClickListener(this);
        ivProfile = view.findViewById(R.id.ivProfile);
        etName = view.findViewById(R.id.etName);
        etMobile = view.findViewById(R.id.etMobile);
        etEmail = view.findViewById(R.id.etEmail);
        etPincode = view.findViewById(R.id.etPincode);
        etState = view.findViewById(R.id.etState);
        etCity = view.findViewById(R.id.etCity);
        etTown = view.findViewById(R.id.etTown);
        etAddress = view.findViewById(R.id.etAddress);
        etAdditionalInf = view.findViewById(R.id.etAdditionalInf);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ibBack:
            case R.id.btnCancel:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new AccountFragment()).commit();
                break;
            case R.id.btnEdit:
                etName.setEnabled(true);
                etMobile.setEnabled(true);
                etEmail.setEnabled(true);
                etPincode.setEnabled(true);
                etState.setEnabled(true);
                etCity.setEnabled(true);
                etTown.setEnabled(true);
                etAddress.setEnabled(true);
                etAdditionalInf.setEnabled(true);
                break;
            case R.id.ibUploadProfile:
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
                break;
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    ivProfile.setBackground(getResources().getDrawable(R.drawable.profile_bg));
                    ivProfile.setImageURI(selectedImageUri);
                }
            }
        }
    }
}
