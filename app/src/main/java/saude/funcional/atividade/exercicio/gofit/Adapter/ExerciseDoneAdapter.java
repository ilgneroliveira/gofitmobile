package saude.funcional.atividade.exercicio.gofit.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import saude.funcional.atividade.exercicio.gofit.ExerciseDoneShowActivity;
import saude.funcional.atividade.exercicio.gofit.Model.ExerciseDone;
import saude.funcional.atividade.exercicio.gofit.Model.ExerciseRecommedation;
import saude.funcional.atividade.exercicio.gofit.R;
import saude.funcional.atividade.exercicio.gofit.ShowExersiceActivity;

public class ExerciseDoneAdapter extends RecyclerView.Adapter<ExerciseDoneAdapter.GroceryViewHolder> {
    private List<ExerciseDone> horizontalGrocderyList;
    Context context;

    public ExerciseDoneAdapter(List<ExerciseDone> horizontalGrocderyList, Context context) {
        this.horizontalGrocderyList = horizontalGrocderyList;
        this.context = context;
    }

    @Override
    public GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_done_item, parent, false);
        GroceryViewHolder gvh = new GroceryViewHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(GroceryViewHolder holder, final int position) {
        holder.imageView.setImageUrl(horizontalGrocderyList.get(position).getExercise().getFeaturedImageUrl());
        holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.txtview.setText(horizontalGrocderyList.get(position).getExercise().getTitle());
        String dataNew = "";

        @SuppressLint("SimpleDateFormat") SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatoViewNew = new SimpleDateFormat("EEE, d 'de' MMM 'de' yyyy 'às' HH:mm");
        try {
            String[] split = horizontalGrocderyList.get(position).getExecute_at().split("\\+");
            Date data1 = formato.parse(split[0]);
            dataNew = formatoViewNew.format(data1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        holder.txtview1.setText(dataNew);
        holder.txtview3.setText(horizontalGrocderyList.get(position).getTimeExecute());

    }

    @Override
    public int getItemCount() {
        return horizontalGrocderyList.size();
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {
        SmartImageView imageView;
        TextView txtview;
        TextView txtview1;
        TextView txtview2;
        TextView txtview3;

        public GroceryViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.idImage);
            txtview = view.findViewById(R.id.idName);
            txtview1 = view.findViewById(R.id.idExecuteAt);
//            txtview2 = view.findViewById(R.id.idHora);
            txtview3 = view.findViewById(R.id.idTime);
        }
    }
}