package sg.edu.np.mad.mad19ct;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RemarksViewHolder extends RecyclerView.ViewHolder {
    TextView txtRemarks;

    public RemarksViewHolder(@NonNull View itemView) {
        super(itemView);
        txtRemarks = itemView.findViewById(R.id.txtRemarks);
    }
}
