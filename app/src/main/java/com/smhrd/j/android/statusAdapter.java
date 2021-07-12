package com.smhrd.j.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class statusAdapter extends BaseAdapter {

    private ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_login_contract,parent,false);

        }

        LoginDTO dto = list.get(position);


        return convertView;
    }
//    public void addItem(String id){
//        LoginDTO dto = new LoginDTO(id);
//        list.add(dto);
//    }
}
