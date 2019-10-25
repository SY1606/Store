package com.science.com.rchs.net;


import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface ApiService {

    //上传头像
    @FormUrlEncoded
    @POST("/api/upload/wechatmediaimg")
    Observable<ResponseBody> getNewDisContent(@Field("token") String token, @Field("stream") String stream);


    //会员列表
    @POST("api/wechat/membershipcard/list")
    Observable<ResponseBody> getMenListContent(@Query("token") String token);

    //会员列表
    @POST("api/wechat/membershipcard/list")
    Observable<ResponseBody> getMenList1Content(@Query("token") String token);

    //登录
    @POST("/api/auth/login")
    Observable<ResponseBody> getLoginContent(@Query("grant_type") String grant_type,
                                      @Query("mch_seller_number") String mch_seller_number,
                                      @Query("password") String password);


    //优惠券列表
    @POST("/api/wechat/couponlist")
    Observable<ResponseBody> getDisListContent(@Query("token") String token, @Query("type") int type);

    //消费记录
    @POST("/api/wechat/membershipcard/getconsumptionrecordlist")
    Observable<ResponseBody> getCRecoderContent(@Query("token") String token);

    //门店首页
    @POST("/api/wechat/mchseller/store/index")
    Observable<ResponseBody> getStoreContent(@Query("token") String token);

    //门店筛选
    @POST("/api/wechat/mchseller/store/index")
    Observable<ResponseBody> getStoresContent(@Query("token") String token,@Query("startTime") int startTime,@Query("endTime") int endTime);

    //首页
    @POST("/api/wechat/membershipcard/index")
    Observable<ResponseBody> getHomeContent(@Query("token") String token);

    //日结清单
    @POST("/api/wechat/mchseller/orders/todaydetailed")
    Observable<ResponseBody> getDalistListContent(@Query("token") String token, @Query("startTime") int startTime,@Query("endTime") int endTime);

    //核销明细
    @POST("/api/wechat/couponoffcodelist")
    Observable<ResponseBody> getDaiContent(@Query("token") String token, @Query("coupon_type") int coupon_type);

    //订单筛选
    @POST("/api/wechat/mchseller/orders/search")
    Observable<ResponseBody> getOrderShaiContent(@Query("token") String token, @Query("type") String type,
                                                 @Query("startTime") int startTime,
                                                 @Query("endTime") int endTime
                                                 );

    //门店列表
    @POST("/api/wechat/mchseller/store/index")
    Observable<ResponseBody> getChooseStoreContent(@Query("token") String token);

    //账单首页
    @POST("/api/wechat/mchseller/orders/index")
    Observable<ResponseBody> getBillContent(@Query("token") String token);

    //微信筛选
    @POST("/api/wechat/mchseller/orders/search")
    Observable<ResponseBody> getWeiContent(@Query("token") String token,
                                           @Query("type") String type,
                                           @Query("startTime") int startTime,
                                           @Query("endTime") int endTime);

    //优惠券信息
    @POST("/api/wechat/checkcouponinfo")
    Observable<ResponseBody> getXinxiContent(@Query("token") String token , @Query("coupon_id") String coupon_id);

    //会员充值记录
    @POST("/api/wechat/membershipcard/getrechargelist")
    Observable<ResponseBody> getChongzhiContent(@Query("token") String token);

    //个人消费记录
    @POST("/api/wechat/membershipcard/getconsumptionrecordlist")
    Observable<ResponseBody> getPCrecoderContent(@Query("token") String token,@Query("phone") String phone);

    //生成付款码
    @POST("/api/wechat/mchseller/get/payurl")
    Observable<ResponseBody> getQRcodeContent(@Query("token") String token);

    //会员搜索
    @POST("/api/wechat/membershipcard/weblist")
    Observable<ResponseBody> getSearchContent(@Query("token") String token,@Query("phone") String phone);



    //发送验证码
    @POST("/api/wechat/sendsms/put/updatedpasswordsendsms")
    Observable<ResponseBody> getSendContent(@Query("phone") String phone);

    //设为默认
    @POST("/api/wechat/mchseller/store/index")
    Observable<ResponseBody> getChooseDStoreContent(@Query("token") String token,@Query("store_id") int store_id);

    //时间
    @POST("/api/wechat/mchsellergather/get/timedivision")
    Observable<ResponseBody> getGukeContent(@Query("token") String token);

    //忘记密码
    @POST("/api/wechat/sendsms/put/updateloginpassword")
    Observable<ResponseBody> getForgetContent(@Query("phone") String phone,
                                            @Query("password") String password,
                                                @Query("passwordtwo") String passwordtwo,
                                                    @Query("signcode") String signcode);

    //商家基本信息
    @POST("/api/wechat/mchseller/get/info")
    Observable<ResponseBody> getShopsContent(@Query("token") String token);

    //扫码开卡
    @POST("/api/wechat/get/cardimage")
    Observable<ResponseBody> getOpenContent(@Query("token") String token,@Query("type") String type);

    //自助支付码
    @POST("/api/wechat/mchseller/get/payurl")
    Observable<ResponseBody> getSelfContent(@Query("token") String token,@Query("store_id") int store_id);

    //门店列表
    @POST("/api/wechat/mchseller/store/index")
    Observable<ResponseBody> getChooseStoreDContent(@Query("token") String token ,@Query("srore_id") int store_id);

    //核销code
    @POST("/api/wechat/offcode")
    Observable<ResponseBody> getHexiaoContent(@Query("token") String token ,@Query("code") String code);

    //会员卡消费
    @POST("/api/wechat/membershipcard/balance")
    Observable<ResponseBody> getXiaofeiContent(@Query("token") String token ,
                                              @Query("card_number") String card_number,
                                               @Query("value") String value,
                                               @Query("remark") String remark);

    //增加代金券
    @POST("/api/wechat/createdcashcoupon")
    Observable<ResponseBody> getAddContent(@Query("token") String token ,
                                               @Query("logo_url") String logo_url,
                                               @Query("color") String color,
                                               @Query("begin_timestamp") String begin_timestamp,
                                               @Query("end_timestamp") String end_timestamp,
                                               @Query("notice") String notice,
                                               @Query("description") String description,
                                               @Query("quantity") int quantity,
                                               @Query("least_cost") String least_cost,
                                               @Query("reduce_cost") String reduce_cost);

    //增加折扣券
    @POST("/api/wechat/createddiscountcoupon")
    Observable<ResponseBody> getAAddZheContent(@Query("token") String token ,
                                           @Query("logo_url") String logo_url,
                                           @Query("color") String color,
                                           @Query("begin_timestamp") String begin_timestamp,
                                           @Query("end_timestamp") String end_timestamp,
                                           @Query("notice") String notice,
                                           @Query("description") String description,
                                           @Query("quantity") int quantity,
                                           @Query("discount") String discount);

    //增加优惠券
    @POST("/api/wechat/createdgeneralcoupon")
    Observable<ResponseBody> getAAddYouContent(@Query("token") String token ,
                                               @Query("logo_url") String logo_url,
                                               @Query("color") String color,
                                               @Query("begin_timestamp") String begin_timestamp,
                                               @Query("end_timestamp") String end_timestamp,
                                               @Query("notice") String notice,
                                               @Query("description") String description,
                                               @Query("quantity") int quantity,
                                               @Query("default_detail") String default_detail);

    //生成付款码
    @POST("/api/wechat/mchseller/get/payurl")
    Observable<ResponseBody> getGudingContent(@Query("token") String token,@Query("money") String money);

    //购买金额分布
    @POST("/api/wechat/mchsellergather/get/moneydivision")
    Observable<ResponseBody> getMoneyContent(@Query("token") String token);


    //购买周期分布
    @POST("/api/wechat/mchsellergather/get/cycledivision")
    Observable<ResponseBody> getWeekContent(@Query("token") String token);


    //提现记录
    @POST("/api/wechat/mchseller/get/starposdraworder")
    Observable<ResponseBody> getTixainContent(@Query("token") String token,@Query("mchId") String mchId);

    //星驿付基本信息
    @POST("/api/wechat/mchseller/get/starposinfo")
    Observable<ResponseBody> getStarContent(@Query("token") String token);

    //绑定友盟
    @POST("/api/wechat/mchseller/bind/device_token")
    Observable<ResponseBody> getBangContent(@Query("token") String token,@Query("device_token") String device_token,@Query("store_id") int store_id,@Query("client_agent") String client_agent);


    //扫码收款
    @POST("/api/wechat/mchseller/payment/scan")
    Observable<ResponseBody> getScantent(@Query("token") String token,
                                         @Query("store_id") int store_id,
                                         @Query("total") String total,
                                         @Query("pay_method") String pay_method,
                                         @Query("pay_code") String pay_code,
    @Query("pay_type") String pay_type);

    //支付宝扫码收款
    @POST("/api/wechat/mchseller/payment/scan")
    Observable<ResponseBody> getScanPaytent(@Query("token") String token,
                                         @Query("store_id") int store_id,
                                         @Query("total") String total,
                                         @Query("pay_method") String pay_method,
                                         @Query("pay_code") String pay_code,
                                         @Query("pay_type") String pay_type);

    //微信优惠券扫码收款
    @POST("/api/wechat/mchseller/payment/scan")
    Observable<ResponseBody> getScan_Paytent(@Query("token") String token,
                                            @Query("store_id") int store_id,
                                            @Query("total") String total,
                                            @Query("pay_method") String pay_method,
                                            @Query("pay_code") String pay_code,
                                            @Query("pay_type") String pay_type,
                                                @Query("coupon_code") String coupon_code);

    //支付宝优惠券扫码收款
    @POST("/api/wechat/mchseller/payment/scan")
    Observable<ResponseBody> getScan_PayStent(@Query("token") String token,
                                             @Query("store_id") int store_id,
                                             @Query("total") String total,
                                             @Query("pay_method") String pay_method,
                                             @Query("pay_code") String pay_code,
                                             @Query("pay_type") String pay_type,
                                             @Query("coupon_code") String coupon_code);


    //核销code
    @POST("/api/wechat/checkcouponcode")
    Observable<ResponseBody> getCodeContent(@Query("token") String token,@Query("coupon_id") String coupon_id,
                                            @Query("code") int code);

    //门店列表
    @POST("/api/wechat/mchseller/store/index")
    Observable<ResponseBody> getStoresContent(@Query("token") String token ,@Query("store_id") int store_id);

    //订单详情
    @POST("/api/wechat/mchseller/orders/info")
    Observable<ResponseBody> getOrderDalistContent(@Query("token") String token ,@Query("orderNumber") String orderNumber);

    //显示文字信息
    @POST("/api/wechat/checkcouponinfoapp")
    Observable<ResponseBody> getCodesContent(@Query("token") String token ,@Query("coupon_code") String coupon_code);


    //编辑折扣券
    @POST("/api/wechat/updatecouponinfo")
    Observable<ResponseBody> getBianjiContent(@Query("token") String token ,
                                              @Query("coupon_id") String coupon_id,
                                                  @Query("type") String type,
                                                      @Query("logo_url") String logo_url,
                                                      @Query("color") String color,
                                              @Query("notice") String notice,
                                              @Query("description") String description,
                                                @Query("begin_timestamp") String begin_timestamp,
                                              @Query("end_timestamp") String end_timestamp);

    //使用优惠券付款
    @POST("/api/wechat/webcheckcouponinfo")
    Observable<ResponseBody> getBianContent(@Query("token") String token ,@Query("coupon_id") String coupon_id);



    //使用优惠券付款
    @POST("/api/wechat/mchseller/payment/scan")
    Observable<ResponseBody> getWxcontent(@Query("token") String token,
                                             @Query("store_id") int store_id,
                                             @Query("total") String total,
                                             @Query("pay_method") String pay_method,
                                             @Query("pay_code") String pay_code,
                                             @Query("pay_type") String pay_type,
                                             @Query("coupon_code") String coupon_code);

    //绑定友盟
    @POST("/api/wechat/mchseller/bind/device_token")
    Observable<ResponseBody> getBanContent(@Query("token") String token,@Query("device_token") String device_token,@Query("store_id") int store_id,@Query("client_agent") String client_agent);



}

