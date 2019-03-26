//package com.yema.retrofittest.utils;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.yatoooon.screenadaptation.ScreenAdapterTools;
//import com.yemast.road.witconstructionsite.R;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//public class UpdateDialog extends Dialog {
//
//    @BindView(R.id.tv_dialog_title)
//    TextView tvDialogTitle;
//    @BindView(R.id.tv_dialog_cancel)
//    TextView tvDialogCancel;
//    @BindView(R.id.tv_dialog_comfirm)
//    TextView tvDialogComfirm;
//    @BindView(R.id.layout_btns)
//    LinearLayout layoutBtns;
//    @BindView(R.id.ll_f_update)
//    LinearLayout llFUpdate;
//    private Context context;
//    private ClickListenerInterface clickListenerInterface;
//    private DownLoadInfo updateBean;
//
//
//    public UpdateDialog(Context context, DownLoadInfo updateBean) {
//        super(context, R.style.dialog);
//        this.context = context;
//        this.updateBean = updateBean;
//    }
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dialog_update);
//        ButterKnife.bind(this);
//        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());
//        tvDialogTitle.setText(updateBean.getDescription());
//
//    }
//
//
//    public void setClicklistener(ClickListenerInterface clickListenerInterface) {
//        this.clickListenerInterface = clickListenerInterface;
//    }
//
//    @OnClick({R.id.tv_dialog_cancel, R.id.tv_dialog_comfirm, R.id.ll_f_update})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.tv_dialog_cancel:
//                clickListenerInterface.cancel();
//                break;
//            case R.id.tv_dialog_comfirm:
//            case R.id.ll_f_update:
//                clickListenerInterface.doConfirm();
//                break;
//        }
//    }
//
//
//    public interface ClickListenerInterface {
//
//        void doConfirm();
//
//        void cancel();
//
//    }
//
//}
