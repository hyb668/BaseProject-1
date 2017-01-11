package com.yunwei.frame.function.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.EditText;

import com.yunwei.frame.R;
import com.yunwei.frame.base.BaseActivity;
import com.yunwei.frame.common.Constant;
import com.yunwei.frame.common.dialog.DialogFactory;
import com.yunwei.frame.function.account.data.soure.AccountRemoteRepo;
import com.yunwei.frame.utils.ISpfUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.account
 * @Description:重置密码
 * @date 2017/1/10 15:33
 */

public class ModifyPasswordActivity extends BaseActivity implements AccountContract.ModifyUserPasswordView {

    @BindView(R.id.pwd_edit_old_edit)
    EditText pwdEditOldEdit;
    @BindView(R.id.pwd_edit_new_edit)
    EditText pwdEditNewEdit;

    private AccountPresenter accountPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_pwd_edit);
        setToolbarTitle(R.string.title_edit_user_pwd);
        setToolbarRightText(R.string.title_submit);
        ButterKnife.bind(this);
        accountPresenter = new AccountPresenter(AccountRemoteRepo.newInstance(), this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        accountPresenter.cancelRequest();
    }

    @Override
    public void onClickToolbarRightLayout() {
        super.onClickToolbarRightLayout();
        if (TextUtils.isEmpty(pwdEditOldEdit.getText().toString())) {
            showToast(R.string.toast_pwd_old_null);
            return;
        }
        if (TextUtils.isEmpty(pwdEditNewEdit.getText().toString())) {
            showToast(R.string.toast_pwd_new_null);
            return;
        }
        if (!pwdEditOldEdit.getText().toString().trim().equals(ISpfUtil.getValue(Constant.PSSWORD_KEY, "").toString().trim())) {
            showToast(R.string.toast_pwd_not_dis);
            return;
        }
        accountPresenter.modifyUserPwd();
    }

    @Override
    public void showModifyPwdDialog() {
        loadDialog = DialogFactory.createLoadingDialog(this, R.string.dialog_msg_modify_pwd);
    }

    @Override
    public void dimissModifyPwdDialog() {
        DialogFactory.dimissDialog(loadDialog);
    }

    @Override
    public void modifyPwdSuccess() {
        showToast(R.string.toast_modify_pwd_success);
    }

    @Override
    public void modifyPwdFailure(String error) {
        showToast(error);
    }

    @Override
    public String getNewPassword() {
        return pwdEditNewEdit.getText().toString();
    }

    @Override
    public String getOldPassword() {
        return pwdEditOldEdit.getText().toString();
    }
}
