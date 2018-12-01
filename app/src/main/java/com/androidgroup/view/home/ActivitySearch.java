package com.androidgroup.view.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.androidgroup.R;

/**
 * Created by 14457 on 2018/10/31.
 */

public class ActivitySearch extends AppCompatActivity {
    private String[] searcoh = {"震惊！每日浏览头条竟然能挣钱","安卓入门","菜鸟教程","android","ddddd","百度","android入门","android从入门到放弃","android进阶","震惊！"};
    private SearchView main_searchview;
    private ListView main_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        findViews();
    }

    private void findViews() {
        main_searchview = (SearchView) findViewById(R.id.main_searchview);
        main_listview = (ListView) findViewById(R.id.main_listview);

        main_listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searcoh));
        main_listview.setTextFilterEnabled(true);

        main_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    main_listview.setFilterText(newText);
                }   else {
                    main_listview.clearChoices();
                }


                return false;
            }
        });


    }
}