package mrhao.com.aomentravel.utils;

import android.content.Context;
import android.content.Intent;

public class StartActivityUtil {
    public static Class startAct(Context context, Class c){
        context.startActivity(new Intent(context,c));
        return c;
    }
}
