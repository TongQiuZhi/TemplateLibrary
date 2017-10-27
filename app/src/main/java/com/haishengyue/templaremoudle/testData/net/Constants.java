package com.haishengyue.templaremoudle.testData.net;

/**
 * 常量类
 *
 * @author losing 2015年7月13日
 */
public class Constants {

    public static final String DB_NAME = "superstar";
    /**
     * 服务环境
     */
    public static boolean IS_DEBUG = false;// 设置是否为调试模式，ture为是，false为否

    /**
     * 日志
     */
    public static boolean LOG_DEBUG = true;//是否为开发者模式(开发模式打印LOG,非开发模式不打印LOG)
    
    
    //视频分享地址
    public static String getVideoShareUrl(){
//        测试的分享地址： http://sharev.heysound.com:9001
//        正式的分享地址: http://sharev.heysound.com
        String str = "";
        if (IS_DEBUG) {
            str = "http://sharev.heysound.com:9001";
        } else {
            str = "http://sharev.heysound.com";
        }
        return str;
    }

    //直播的后台服务器地址
    public static String getLiveBaseUrl(){
        String str = "";
        if (IS_DEBUG) {
            str = "http://121.43.114.232:9878/sxb/index.php?";
//            str = "http://192.168.199.204:32772/dashboard/index.php?";
        } else {
            str = "http://121.43.114.232:8887/sxb/index.php?";
        }
        return str;
    }

    // 服务器地址
    public static String SERVER_URL() {
        String str = "";
        if (IS_DEBUG) {
            str = "http://120.26.161.34:9988";
        } else {
            str = "http://superstar.heysound.com";
        }
        return str;
    }

    // 用户收货地址服务器
    //2017.01.03  http://test.heysound.com
    public static String USERADDR_URL() {
        String str = "";
        if (IS_DEBUG) {
            str = "http://120.26.161.34:9080";
        } else {
            str = "http://test.heysound.com";
        }
        return str;
    }

    //
    public static final String KUAIDI_100 = "392EF29C60152325D95A1D0A1EC7311F";

    //
    public static final String APP_KEY = "android_f89c88a914e2d69c";
    public static final String APP_SECRET = "69e66f609f036fd7c47ce307cc7c616c";
    

    //账号类型
    public static final String ACCOUNT_WX = "0";//微信
    public static final String ACCOUNT_ALI = "1";//支付宝
    public static final String ACCOUNT_BANK = "2";//银行卡

    // myGridView
    public static int GRIVIEW_COLUMN_HEIGHT = 0;// griview设置的高度
    public static int GRIVEW_COLUMN_NUMS = 3;// 列数

    /**
     * 订单状态
     * 待支付WaitPay,已支付Paid,已发货Sent,完成Completed,取消Cancel,AfterService
     */
    public static final String ORDER_ALL = "";
    public static final String ORDER_WAIT_PAY = "WaitPay";
    public static final String ORDER_PAID = "Paid";
    public static final String ORDER_SENT = "Sent";
    public static final String ORDER_COMPLETED = "Completed";
    public static final String ORDER_CANCEL = "Cancel";
    public static final String ORDER_AFTERSERVICE = "AfterService";
    public static final String ORDER_EVALUATE = "Evaluate";

    //
    public static final String IM_APP_KEY = "23511644";

    //根据videoItemId拼接视频播放地址
    public static String getVideoShareUrl(String videoItemId){
//        return "http://sharev.heysound.com/video_detail/"+videoItemId+"?from=groupmessage&isappinstalled=0";
//        return "http://sharev.heysound.com/video_detail/"+videoItemId;
        return getVideoShareUrl()+"/video_detail/"+videoItemId;
    }

    //提现说明地址
    public static String getWithdrawInstruction(){
        return getVideoShareUrl()+"/withdrawForApp";
    }
    
    //提现输入管理数据说明地址
    public static String getWithdrawAmoutExplain(){
        return getVideoShareUrl()+"/incomeIntro";
    }
    
}
