package com.fachrur_122.newmovie.sortMovies;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.fachrur_122.newmovie.Interface.SortingDialogView;
import com.fachrur_122.newmovie.R;
import com.fachrur_122.newmovie.list.MoviesListingPresenter;

/**
 * Created by fachrur_122 on 30/04/2016.
 *
 */
public abstract class SortingDialogFragment extends DialogFragment implements SortingDialogView, RadioGroup.OnCheckedChangeListener {

    private RadioGroup mSortingOptionsGroup;
    private static MoviesListingPresenter mMoviesListingPresenter;
    private com.fachrur_122.newmovie.Interface.SortingDialogPresenter mSortingDialogPresenter;



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.sorting_options, null);
        initViews(dialogView);

        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(dialogView);
        dialog.setTitle(R.string.sort_by);
        dialog.show();
        return dialog;
    }

    private void initViews(View dialogView) {
        mSortingOptionsGroup = (RadioGroup) dialogView.findViewById(R.id.sorting_group);
        mSortingDialogPresenter = new SortingDialogPresenter(this);
        mSortingDialogPresenter.setLastSavedOption();
        mSortingOptionsGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void setPopularChecked() {
        RadioButton popular = (RadioButton) mSortingOptionsGroup.findViewById(R.id.most_popular);
        popular.setChecked(true);
    }




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.most_popular:
                mSortingDialogPresenter.onPopularMoviesSelected();
                mMoviesListingPresenter.displayMovies();
                break;




        }
    }

    @Override
    public void dismissDialog() {
        dismiss();
    }

}
