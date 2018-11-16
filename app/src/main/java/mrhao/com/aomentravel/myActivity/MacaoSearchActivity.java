package mrhao.com.aomentravel.myActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.utils.MySearchViewUtils.ICallBack;
import mrhao.com.aomentravel.utils.MySearchViewUtils.MySearchView;

public class MacaoSearchActivity extends BaseActivity {

    @BindView(R.id.mysearch_view)
    MySearchView mysearchView;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macao_search);
        ButterKnife.bind(this);
        setSearchEvent();
    }

    private void setSearchEvent() {

        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        mysearchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {

            }
        });
    }
}
