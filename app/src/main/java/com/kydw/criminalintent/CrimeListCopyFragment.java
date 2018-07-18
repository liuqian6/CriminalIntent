package com.kydw.criminalintent;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * @author liuqian
 * @date 2018/7/18 9:07
 */
public class CrimeListCopyFragment extends Fragment {

    RecyclerView mRecyclerView;
    CrimeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mRecyclerView = view.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mRecyclerView.setAdapter(mAdapter);
    }

    class CrimeViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mDate;

        CrimeViewHolder(@NonNull LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.list_item_crime, container, false));
            mTitle = itemView.findViewById(R.id.crime_title);
            mDate = itemView.findViewById(R.id.crime_date);
        }

        public void bond(Crime crime) {
            mTitle.setText(crime.getTitle());
            mDate.setText(crime.getDate().toString());
        }
    }

    class CrimeAdapter extends RecyclerView.Adapter<CrimeViewHolder> {

        private List<Crime> mCrimes;

        CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new CrimeViewHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeViewHolder crimeViewHolder, int i) {
            crimeViewHolder.bond(mCrimes.get(i));
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}