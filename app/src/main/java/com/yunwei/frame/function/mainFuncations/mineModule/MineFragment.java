package com.yunwei.frame.function.mainFuncations.mineModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yunwei.frame.R;
import com.yunwei.frame.common.Constant;
import com.yunwei.frame.common.dialog.DialogFactory;
import com.yunwei.frame.function.account.LoginActivity;
import com.yunwei.frame.function.account.UserInfoActivity;
import com.yunwei.frame.function.account.data.UserInfoEntity;
import com.yunwei.frame.base.BaseFragment;
import com.yunwei.frame.base.DataApplication;
import com.yunwei.frame.function.deviceFuncations.picture.PictureContract;
import com.yunwei.frame.function.deviceFuncations.picture.PicturePresenter;
import com.yunwei.frame.function.deviceFuncations.picture.SelectPictrueAdapter;
import com.yunwei.frame.function.deviceFuncations.picture.SelectPictureActivity;
import com.yunwei.frame.function.deviceFuncations.picture.ShowPictureActivity;
import com.yunwei.frame.function.deviceFuncations.picture.data.PictureEntity;
import com.yunwei.frame.function.mainFuncations.mineModule.fragment.AboutFragment;
import com.yunwei.frame.function.mainFuncations.mineModule.fragment.MessageSetingFragment;
import com.yunwei.frame.function.mainFuncations.mineModule.fragment.TrackSetingFragment;
import com.yunwei.frame.utils.IActivityManage;
import com.yunwei.frame.utils.ISkipActivityUtil;
import com.yunwei.frame.utils.ISpfUtil;
import com.yunwei.frame.utils.IUtil;
import com.yunwei.frame.view.RoundedBitmapImageViewTarget;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.mainFuncations.homeFuncation
 * @Description:我的主界面
 * @date 2016/11/22 18:12
 */

public class MineFragment extends BaseFragment {

    private static MineFragment fragment;
    @BindView(R.id.userInfo_headView_iv)
    ImageView userInfoHeadViewIv;
    @BindView(R.id.userInfo_name_textView)
    TextView userInfoNameTextView;
    @BindView(R.id.userInfo_dev_textView)
    TextView userInfoDevTextView;

    public static MineFragment newInstance() {
        if (fragment == null) {
            fragment = new MineFragment();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment_mine, null);
        ButterKnife.bind(this, rootView);
        initUI();
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Glide.with(getActivity()).load(IUtil.fitterUrl(DataApplication.getInstance().getUserInfoEntity().getIcon())).asBitmap().centerCrop().into(new RoundedBitmapImageViewTarget(userInfoHeadViewIv));
    }

    /**
     * 初始化UI
     */
    private void initUI() {
        UserInfoEntity userInfoEntity = DataApplication.getInstance().getUserInfoEntity();
        if (userInfoEntity == null) {
            return;
        }
        userInfoNameTextView.setText(userInfoEntity.getName());
        userInfoDevTextView.setText(userInfoEntity.getDept());
    }

    @OnClick({R.id.userInfo_Layout, R.id.MineFragment_Message_seting_textView, R.id.MineFragment_Track_seting_textView, R.id.MineFragment_about_textView, R.id.MineFragment_switch_user_textView, R.id.MineFragment_exit_textView})
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.userInfo_Layout:
                ISkipActivityUtil.startIntent(getActivity(), UserInfoActivity.class);
                break;
            case R.id.MineFragment_Message_seting_textView:
                bundle.putString(SetingInfoActivity.SHOW_FRAGMENT_FLAG, MessageSetingFragment.FRAGMENT_FLAG);
                bundle.putString(SetingInfoActivity.HEAD_TITLE_FLAG, getString(R.string.set_msg_info));
                ISkipActivityUtil.startIntent(getActivity(), SetingInfoActivity.class, bundle);
                break;
            case R.id.MineFragment_Track_seting_textView:
                bundle.putString(SetingInfoActivity.SHOW_FRAGMENT_FLAG, TrackSetingFragment.FRAGMENT_FLAG);
                bundle.putString(SetingInfoActivity.HEAD_TITLE_FLAG, getString(R.string.set_track_info));
                ISkipActivityUtil.startIntent(getActivity(), SetingInfoActivity.class, bundle);
                break;
            case R.id.MineFragment_about_textView:
                bundle.putString(SetingInfoActivity.SHOW_FRAGMENT_FLAG, AboutFragment.FRAGMENT_FLAG);
                bundle.putString(SetingInfoActivity.HEAD_TITLE_FLAG, getString(R.string.set_about));
                ISkipActivityUtil.startIntent(getActivity(), SetingInfoActivity.class, bundle);
                break;
            case R.id.MineFragment_switch_user_textView:
                showSwitchUserDialog();
                break;
            case R.id.MineFragment_exit_textView:
                showExitAppDialog();
                break;
        }
    }

    /**
     * 切換用戶Dialog
     */
    private void showSwitchUserDialog() {
        DialogFactory.showMsgDialog(getActivity(), getString(R.string.dialog_title_switch_user), getString(R.string.switch_user_msg), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ISpfUtil.setValue(Constant.PSSWORD_KEY, "");
                IActivityManage.getInstance().exit();
                ISkipActivityUtil.startIntent(getActivity(), LoginActivity.class);
            }
        });
    }

    /**
     * 退出Dialog
     */
    private void showExitAppDialog() {
        DialogFactory.showMsgDialog(getActivity(), getString(R.string.dialog_title_exit), getString(R.string.exit_msg) + getString(R.string.app_name) + "?", getString(R.string.exit), getString(R.string.dialog_defalut_cancel_text), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.gc();
                IActivityManage.getInstance().exit();
                System.exit(0);
            }
        }, null);
    }
}
