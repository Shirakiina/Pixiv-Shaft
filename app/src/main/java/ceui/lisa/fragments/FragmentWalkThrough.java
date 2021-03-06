package ceui.lisa.fragments;

import androidx.recyclerview.widget.GridLayoutManager;

import ceui.lisa.adapters.BaseAdapter;
import ceui.lisa.adapters.IAdapter;
import ceui.lisa.core.NetControl;
import ceui.lisa.databinding.FragmentBaseListBinding;
import ceui.lisa.databinding.RecyIllustStaggerBinding;
import ceui.lisa.http.Retro;
import ceui.lisa.model.ListIllust;
import ceui.lisa.models.IllustsBean;
import ceui.lisa.utils.DensityUtil;
import ceui.lisa.view.GridItemDecoration;
import io.reactivex.Observable;

import static ceui.lisa.activities.Shaft.sUserModel;

public class FragmentWalkThrough extends NetListFragment<FragmentBaseListBinding,
        ListIllust, IllustsBean, RecyIllustStaggerBinding> {

    @Override
    public NetControl<ListIllust> present() {
        return new NetControl<ListIllust>() {
            @Override
            public Observable<ListIllust> initApi() {
                return Retro.getAppApi().getLoginBg(sUserModel.getResponse().getAccess_token() + "123456");
            }

            @Override
            public Observable<ListIllust> initNextApi() {
                return null;
            }
        };
    }

    @Override
    public BaseAdapter<IllustsBean, RecyIllustStaggerBinding> adapter() {
        return new IAdapter(allItems, mContext, true);
    }

    @Override
    public String getToolbarTitle() {
        return "画廊";
    }

    @Override
    public void initRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        baseBind.recyclerView.setLayoutManager(manager);
        baseBind.recyclerView.addItemDecoration(new GridItemDecoration(2,
                DensityUtil.dp2px(8.0f), true));
    }
}
