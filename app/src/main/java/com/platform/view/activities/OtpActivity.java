package com.platform.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.platform.R;
import com.platform.models.login.LoginInfo;
import com.platform.utility.Constants;
import com.platform.view.fragments.OtpFragment;

public class OtpActivity extends BaseActivity implements View.OnClickListener {

    private final String TAG = OtpActivity.class.getName();
    private LoginInfo loginInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        initView();
    }

    private void initView() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            loginInfo = bundle.getParcelable(Constants.Login.LOGIN_OTP_VERIFY_DATA);
        }

        try {
            OtpFragment otpFragment = new OtpFragment();
            Bundle data = new Bundle();
            data.putParcelable(Constants.Login.LOGIN_OTP_VERIFY_DATA, loginInfo);
            otpFragment.setArguments(data);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.otp_form_container, otpFragment).commit();
        } catch (Exception e) {
            Log.e(TAG, "Exception :: OtpActivity : initView");
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

    }
}
