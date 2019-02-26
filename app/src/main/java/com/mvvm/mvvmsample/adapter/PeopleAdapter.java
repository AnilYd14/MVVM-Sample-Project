package com.mvvm.mvvmsample.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvvm.mvvmsample.R;
import com.mvvm.mvvmsample.databinding.ItemPeopleBinding;
import com.mvvm.mvvmsample.interfaces.HomeNavigator;
import com.mvvm.mvvmsample.model.People;
import com.mvvm.mvvmsample.viewModel.ItemPeopleViewModel;
import com.mvvm.mvvmsample.views.HomeActivity;

import java.util.ArrayList;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {
    private final Context mContext;
    private final ArrayList<People> peopleList;
    private HomeNavigator itemclickListener;

    public PeopleAdapter(Context mContext, ArrayList<People> peopleList) {

        this.mContext = mContext;
        this.peopleList = peopleList;
    }

    @NonNull
    @Override
    public PeopleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemPeopleBinding itemPeopleBinding =
                DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_people,
                        viewGroup, false);
        return new ViewHolder(itemPeopleBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PeopleAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bindPeople(peopleList.get(i));

    }


    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    public void setNavigator(HomeNavigator itemclickListener) {

        this.itemclickListener = itemclickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ItemPeopleBinding mItemPeopleBinding;

        ViewHolder(@NonNull ItemPeopleBinding itemPeopleBinding) {
            super(itemPeopleBinding.itemPeople);
            this.mItemPeopleBinding = itemPeopleBinding;
            itemPeopleBinding.itemPeople.setOnClickListener(this);
        }
        void bindPeople(People people) {
            if (mItemPeopleBinding.getPeopleViewModel() == null) {
                mItemPeopleBinding.setPeopleViewModel(
                        new ItemPeopleViewModel(people, itemView.getContext()));
            } else {
                mItemPeopleBinding.getPeopleViewModel().setPeople(people);
            }
        }

        @Override
        public void onClick(View v) {
            if(itemclickListener !=null){
                itemclickListener.onItemClick();
            }

        }
    }
    }



