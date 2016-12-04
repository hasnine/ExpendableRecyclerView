package soganiabhijeet.com.expandablecustomlistview.model;

import android.view.View;

import java.util.ArrayList;


public class TitleModel extends BaseListModel  implements View.OnClickListener{

    public String name;

    public ArrayList<BaseListModel> children;

    public Boolean isCurrentlyOpen;

    @Override
    public void onClick(View v) {

    }
}
