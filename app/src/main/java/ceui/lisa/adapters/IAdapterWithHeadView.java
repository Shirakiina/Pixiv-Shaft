package ceui.lisa.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.R;
import ceui.lisa.activities.ViewPagerActivity;
import ceui.lisa.core.RecmdHeader;
import ceui.lisa.core.TagFilter;
import ceui.lisa.databinding.RecyIllustStaggerBinding;
import ceui.lisa.interfaces.MultiDownload;
import ceui.lisa.interfaces.OnItemClickListener;
import ceui.lisa.models.IllustsBean;
import ceui.lisa.utils.DataChannel;
import ceui.lisa.utils.GlideUtil;

public class IAdapterWithHeadView extends IAdapter {

    private RecmdHeader mRecmdHeader = null;

    public IAdapterWithHeadView(List<IllustsBean> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public int headerSize() {
        return 1;
    }

    @Override
    public ViewHolder getHeader(ViewGroup parent) {
        mRecmdHeader = new RecmdHeader(DataBindingUtil.inflate(
                LayoutInflater.from(mContext), R.layout.recy_recmd_header,
                null, false).getRoot());
        mRecmdHeader.initView(mContext);
        return mRecmdHeader;
    }

    public void setHeadData(List<IllustsBean> illustsBeans) {
        if (mRecmdHeader != null) {
            mRecmdHeader.show(mContext, illustsBeans);
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if(lp instanceof StaggeredGridLayoutManager.LayoutParams
                && holder.getLayoutPosition() == 0) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(true);
        }
    }
}
