package me.jartigag.showsguide;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.Arrays;

public class ShowsListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private String[] shows = {"Serie1","Serie2","Serie3","Serie4"};
    //private String[] shows = context.getResources().getStringArray(R.array.shows); //TODO getStringArray(R.array.shows) from Trakt.tv API
    private String[][] seasons;
    private String[] dummySeasons = {"Temporada1","Temporada2","Temporada3","Temporada4","Temporada5"};

    public ShowsListAdapter (Context context) {
        super();
        this.context = context;
        seasons = new String[shows.length][];

        for (int i=0; i<seasons.length; i++) {
            /*
            int seasonNum = context.getResources().getIdentifier("Show" + (i+1), "array", context.getPackageName());
            seasons[i] = context.getResources().getStringArray(seasonNum);
            */
            seasons[i] = dummySeasons;
        } //TODO get seasons from Trakt.tv API
    }

    public Class<? extends Activity> getShowClass(int groupPosition, int childPosition, long id) {
        String chapterId = "Season" + (groupPosition + 1) + "Chapter" + (childPosition + 1); //TODO get chapterId from Trakt.tv API
        return ShowActivityMapper.getShowClass(chapterId);
    }

    @Override
    public int getGroupCount() {
        return shows.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return seasons.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return shows[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return seasons[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cell, null, false);
        }

        TextView textView = view.findViewById(R.id.tvText);
        textView.setText(getGroup(groupPosition).toString());
        return textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
        SecondLevelExpandableListView secondLevelELV = new SecondLevelExpandableListView(context);
        secondLevelELV.setAdapter(new SeasonsListAdapter(context, groupPosition));
        return secondLevelELV;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public class SecondLevelExpandableListView extends ExpandableListView {

        public SecondLevelExpandableListView(Context context) {
            super(context);
        }
    }

    public class SeasonsListAdapter extends BaseExpandableListAdapter {

        private Context context;
        private String[][] chapters;
        private int showNum;

        public SeasonsListAdapter(Context context, int showNum) {
            super();
            this.context = context;
            this.showNum = showNum;
            chapters = new String[seasons.length][];
            String[][] dummyChapters = {{"1","2"},{"1","2","3"},{"1","2","3","4"},{"1","2","3","4","5"}};


            for (int i=0; i<chapters.length; i++) {
                /*
                int chapterNum = context.getResources().getIdentifier("Chapter" + (i+1), "array", context.getPackageName());
                chapters[i] = context.getResources().getStringArray(chapterNum);
                */
                chapters[i] = dummyChapters[i];
            } //TODO get chapters from Trakt.tv API
        }

        @Override
        public int getGroupCount() {
            return seasons.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return chapters.length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return seasons[showNum][groupPosition]; //TODO FIRST!! make showNum work so season array is the correct for each groupPosition
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return chapters[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }


        @Override
        public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cell, null, false);
            }

            TextView textView = view.findViewById(R.id.tvText);
            textView.setText(getGroup(groupPosition).toString());
            return textView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
            //TODO SECOND!! reach this line (that means, show the 3rd level list)
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_cell, null, false);
            }

            TextView textView = view.findViewById(R.id.tvText);
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

}
