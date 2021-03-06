package soganiabhijeet.com.expandablecustomlistview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import soganiabhijeet.com.expandablecustomlistview.model.BaseListModel;


public abstract class BaseViewHolder<T extends BaseListModel> extends RecyclerView.ViewHolder implements View.OnClickListener {
    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void populate(T baseSliderModel);

}
