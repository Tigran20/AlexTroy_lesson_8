package com.alextroy.alextroydb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alextroy.alextroydb.model.local.Node;

import java.util.List;

public class NodeRecyclerAdapter extends RecyclerView.Adapter<NodeRecyclerAdapter.ViewHolder> {

    private List<Node> nodes;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView value;

        ViewHolder(View itemView) {
            super(itemView);

            value = itemView.findViewById(R.id.value);
        }
    }

    public NodeRecyclerAdapter(Context context, List<Node> node) {
        this.nodes = node;
        this.context = context;
    }

    @Override
    public NodeRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Node node = nodes.get(position);

        TextView value = holder.value;

        value.setText(node.getValue());
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

    public void addItem(int position, Node node) {
        this.nodes.add(position, node);
        super.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        this.nodes.remove(position);
        super.notifyItemRemoved(position);
    }


}

