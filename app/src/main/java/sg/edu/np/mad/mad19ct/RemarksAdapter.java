package sg.edu.np.mad.mad19ct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RemarksAdapter extends RecyclerView.Adapter<RemarksViewHolder>{
    Context context;
    ArrayList<String> data;

    public RemarksAdapter(Context c, ArrayList<String> d)
    {
        context = c;
        data = d;
    }

    @NonNull
    @Override
    public RemarksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_timer, parent, false);

        return new RemarksViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RemarksViewHolder holder, int position) {
        String d = data.get(position);
        holder.txtRemarks.setText(d);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
