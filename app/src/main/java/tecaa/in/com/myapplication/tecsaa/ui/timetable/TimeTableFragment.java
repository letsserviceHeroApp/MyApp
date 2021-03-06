package tecaa.in.com.myapplication.tecsaa.ui.timetable;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import tecaa.in.com.myapplication.tecsaa.ChildTimeTableFragment;
import tecaa.in.com.myapplication.tecsaa.R;
import tecaa.in.com.myapplication.tecsaa.ui.gallary.GallaryFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;


public class TimeTableFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TimeTableViewModel slideshowViewModel;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(TimeTableViewModel.class);
        View root = inflater.inflate(R.layout.fragment_time_table, container, false);



        viewPager = (ViewPager)  root.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)  root.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFrag(new ChildTimeTableFragment(), "Monday");
        adapter.addFrag(new ChildTimeTableFragment(), "Tuesday");
        adapter.addFrag(new ChildTimeTableFragment(), "Wednesday");
        adapter.addFrag(new ChildTimeTableFragment(), "Thursday");
        adapter.addFrag(new ChildTimeTableFragment(), "Friday");
        adapter.addFrag(new ChildTimeTableFragment(), "Saturday");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(final int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(final int position) {
            return mFragmentTitleList.get(position);
        }
    }
}