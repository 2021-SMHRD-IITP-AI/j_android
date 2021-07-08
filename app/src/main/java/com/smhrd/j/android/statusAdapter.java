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

//        TextView tv_chat_id = convertView.findViewById(R.id.tv_chat_id);
//        TextView tv_chat_chat = convertView.findViewById(R.id.tv_chat_chat);

        LoginDTO dto = list.get(position);
//        tv_chat_id.setText(dto.getId());



        return convertView;
    }
//    public void addItem(String id){
//        LoginDTO dto = new LoginDTO(id);
//        list.add(dto);
//    }
}
