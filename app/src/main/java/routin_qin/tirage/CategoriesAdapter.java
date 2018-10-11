package routin_qin.tirage;

import android.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private final List<Pair<String, String>> categories = Arrays.asList(
            Pair.create("Categorie 1", "Première catégorie de l'application."),
            Pair.create("Categorie 2", "Deuxième catégorie de l'application."),
            Pair.create("Categorie 3", "Troisième catégorie de l'application.")
    );

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_categories, parent, false);
        return new CategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, int position) {
        Pair<String, String> pair = categories.get(position);
        holder.display(pair);
    }

    public class CategoriesViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView description;
        private final ImageView image;

        private Pair<String, String> currentPair;

        public CategoriesViewHolder(final View itemView) {
            super(itemView);

            title = ((TextView) itemView.findViewById(R.id.tv_categories_title));
            description = ((TextView) itemView.findViewById(R.id.tv_categories_description));
            image = ((ImageView) itemView.findViewById(R.id.iv_categories_image));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentPair.first)
                            .setMessage(currentPair.second)
                            .show();
                }
            });
        }

        public void display(Pair<String, String> pair) {
            currentPair = pair;
            title.setText(pair.first);
            description.setText(pair.second);
        }
    }

}
