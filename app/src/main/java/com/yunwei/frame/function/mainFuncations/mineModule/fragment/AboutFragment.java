package com.yunwei.frame.function.mainFuncations.mineModule.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yunwei.frame.R;
import com.yunwei.frame.base.BaseFragment;
import com.yunwei.frame.common.dialog.DialogFactory;
import com.yunwei.frame.function.mainFuncations.mineModule.CheckAppVersion.CheckAppVersionContract;
import com.yunwei.frame.function.mainFuncations.mineModule.CheckAppVersion.CheckAppVersionPresenter;
import com.yunwei.frame.function.mainFuncations.mineModule.data.source.CheckAppVersionRemoteRepo;
import com.yunwei.frame.utils.ISystemUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.mainFuncations.mineFuncation.fragment
 * @Description:关于界面
 * @date 2016/11/28 10:23
 */

public class AboutFragment extends BaseFragment implements CheckAppVersionContract.View {

    public final static String FRAGMENT_FLAG = "aboutFragment";

    @BindView(R.id.version_text)
    TextView versionText;

    private CheckAppVersionPresenter versionPresenter;

    private static AboutFragment instance;

    public static AboutFragment newInstance() {
        if (instance == null) {
            instance = new AboutFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        versionPresenter = new CheckAppVersionPresenter(CheckAppVersionRemoteRepo.newInstance(), this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mine_about_fragment, null);
        ButterKnife.bind(this, rootView);
        versionText.setText(getString(R.string.app_name) + "V" + ISystemUtil.getVersionName());
        return rootView;
    }

    @OnClick(R.id.check_app_text)
    public void onClick() {
        versionPresenter.checkAppVersion();
    }

    @Override
    public void showRequestFail() {
        showToast(R.string.taost_version_failure);
    }

    @Override
    public void showIsLatestVersion() {
        showToast(R.string.toast_version_later);
    }

    @Override
    public void showCheckingDialog() {
        loadDialog = DialogFactory.createLoadingDialog(getActivity(), R.string.dialog_msg_check_app_ver);
    }

    @Override
    public void dismissCheckingDialog() {
        DialogFactory.dimissDialog(loadDialog);
    }
}
