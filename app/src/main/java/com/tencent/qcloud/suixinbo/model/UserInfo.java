package com.tencent.qcloud.suixinbo.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.tencent.qcloud.suixinbo.utils.Constants;

/**
 * 用户数据
 */
public class UserInfo {
    private static final String TAG = UserInfo.class.getSimpleName();
    private String id;
    private String userSig;

    private int myRoomNum;

    private static UserInfo ourInstance = new UserInfo();

    public static UserInfo getInstance() {

        return ourInstance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserSig() {
        return userSig;
    }

    public void setUserSig(String userSig) {
        this.userSig = userSig;
    }


    public int getMyRoomNum() {
        return myRoomNum;
    }

    public void setMyRoomNum(int myRoomNum) {
        this.myRoomNum = myRoomNum;
    }


    public void writeToCache(Context context, String id, String sig, int roomnum) {
        SharedPreferences settings = context.getSharedPreferences(Constants.USER_INFO, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(Constants.USER_ID, id);
        editor.putString(Constants.USER_SIG, sig);
        editor.putInt(Constants.USER_ROOM_NUM, roomnum);
        editor.commit();
    }

    public void clearCache(Context context) {
        SharedPreferences settings = context.getSharedPreferences(Constants.USER_INFO, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();
    }

    public void getCache(Context context) {
        SharedPreferences sharedata = context.getSharedPreferences(Constants.USER_INFO, 0);
        id = sharedata.getString(Constants.USER_ID, null);
        userSig = sharedata.getString(Constants.USER_SIG, null);
        myRoomNum = sharedata.getInt(Constants.USER_ROOM_NUM, -1);
        Log.i(TAG, " getCache id: "+id);
    }


}