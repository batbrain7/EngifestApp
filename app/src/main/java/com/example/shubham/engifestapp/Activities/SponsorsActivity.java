package com.example.shubham.engifestapp.Activities;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;

import com.example.shubham.engifestapp.Adapters.SponsorAdapter;
import com.example.shubham.engifestapp.Models.SponsorData;
import com.example.shubham.engifestapp.R;

import java.util.ArrayList;

public class SponsorsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<SponsorData> arrayList = new ArrayList<SponsorData>();
    SponsorAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adapter = new SponsorAdapter(SponsorsActivity.this,arrayList);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_sponsors);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(15), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

    }

    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.stryker,
                R.drawable.pepsi,
                R.drawable.din,
                R.drawable.fc,
                R.drawable.jh,
                R.drawable.nestle,
                R.drawable.loyalcard,
                R.drawable.sbi,
                R.drawable.unk,R.drawable.ioa,R.drawable.ignite,R.drawable.paytm,R.drawable.play,
                R.drawable.bmtc,R.drawable.ddelhi,R.drawable.mankind
        };


        SponsorData a = new SponsorData("Stryker",covers[0]);
        arrayList.add(a);

        a = new SponsorData("Pepsi",covers[1]);
        arrayList.add(a);

        a = new SponsorData("DOT In",covers[2]);
        arrayList.add(a);

        a = new SponsorData("Food Sponsor",covers[3]);
        arrayList.add(a);

        a = new SponsorData("Jawed habib",covers[4]);
        arrayList.add(a);

        a = new SponsorData("Nestle",covers[5]);
        arrayList.add(a);

        a = new SponsorData("",covers[6]);
        arrayList.add(a);

        a = new SponsorData("SBI",covers[7]);
        arrayList.add(a);

        a = new SponsorData("",covers[8]);
        arrayList.add(a);

        a = new SponsorData("",covers[9]);
        arrayList.add(a);

        a = new SponsorData("",covers[10]);
        arrayList.add(a);

        a = new SponsorData("",covers[11]);
        arrayList.add(a);

        a = new SponsorData("",covers[12]);
        arrayList.add(a);

        a = new SponsorData("",covers[13]);
        arrayList.add(a);

        a = new SponsorData("",covers[14]);
        arrayList.add(a);

        a = new SponsorData("",covers[15]);
        arrayList.add(a);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
