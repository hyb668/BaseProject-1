package com.yunwei.frame.function.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yunwei.frame.R;
import com.yunwei.frame.base.BaseActivity;
import com.yunwei.frame.base.DataApplication;
import com.yunwei.frame.common.Constant;
import com.yunwei.frame.function.account.data.UserInfoEntity;
import com.yunwei.frame.utils.ISkipActivityUtil;
import com.yunwei.frame.utils.ISpfUtil;
import com.yunwei.frame.utils.IUtil;
import com.yunwei.frame.view.RoundedBitmapImageViewTarget;
import com.yunwei.frame.widget.FormWriteView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.account
 * @Description:
 * @date 2017/1/9 15:10
 */

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.UserInfo_HeadView_imageView)
    ImageView UserInfoHeadViewImageView;
    @BindView(R.id.UserInfo_account_textView)
    FormWriteView UserInfoAccountTextView;
    @BindView(R.id.UserInfo_depart_textView)
    FormWriteView UserInfoDepartTextView;
    @BindView(R.id.UserInfo_company_textView)
    FormWriteView UserInfoCompanyTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        setToolbarRightText(R.string.title_user_info_edit);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initUI();
    }

    private void initUI() {
        UserInfoEntity userInfoEntity = DataApplication.getInstance().getUserInfoEntity();
        if (userInfoEntity == null) {
            return;
        }
        Glide.with(this).load(IUtil.fitterUrl(DataApplication.getInstance().getUserInfoEntity().getIcon())).asBitmap().centerCrop().into(new RoundedBitmapImageViewTarget(UserInfoHeadViewImageView));
        UserInfoAccountTextView.setContentText(ISpfUtil.getValue(Constant.ACCOUNT_KEY, "").toString()).setNonEditable();
        UserInfoDepartTextView.setContentText(userInfoEntity.getDept()).setNonEditable();
        UserInfoCompanyTextView.setContentText(userInfoEntity.getUnit()).setNonEditable();
    }

    @Override
    public void onClickToolbarRightLayout() {
        super.onClickToolbarRightLayout();
        ISkipActivityUtil.startIntent(this,EditUserInfoActivity.class);
    }
}
