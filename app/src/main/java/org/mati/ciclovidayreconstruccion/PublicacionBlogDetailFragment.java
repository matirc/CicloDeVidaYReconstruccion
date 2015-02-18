package org.mati.ciclovidayreconstruccion;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import org.mati.ciclovidayreconstruccion.dummy.DummyContent;

/**
 * A fragment representing a single PublicacionBlog detail screen.
 * This fragment is either contained in a {@link PublicacionBlogListActivity}
 * in two-pane mode (on tablets) or a {@link PublicacionBlogDetailActivity}
 * on handsets.
 */
public class PublicacionBlogDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PublicacionBlogDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_publicacionblog_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            // Aqui se asignan los valores a los campos de los items
            ((TextView) rootView.findViewById(R.id.publicacionblog_detail2)).setText(mItem.content);
            ((TextView) rootView.findViewById(R.id.publicacionblog_detail1)).setText(mItem.Descripcion);
        }

        return rootView;
    }
}
