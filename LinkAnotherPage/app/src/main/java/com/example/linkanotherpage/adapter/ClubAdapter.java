//package com.example.linkanotherpage.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.linkanotherpage.R;
//import com.example.linkanotherpage.model.ClubModel;
//
//import java.util.List;
//
//public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.MemberViewHolder> {
//
//
//
//    private List<ClubModel> memberList;
//
//    private Context context;
//
//    public ClubAdapter(List<ClubModel> memberList, Context context) {
//        this.memberList = memberList;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public ClubAdapter.MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.member_detils, parent, false);
//
//        return new  MemberViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ClubAdapter.MemberViewHolder holder, int position) {
//
//        ClubModel member = memberList.get(position)
//                holder.bind(member);
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return memberList.size();
//    }
//
//
//
//    static class MemberViewHolder extends RecyclerView.ViewHolder {
//        private TextView nameTextView;
//        private TextView clubPositionTextView;
//        private TextView address1TextView;
//        private TextView address2TextView;
//        private TextView phoneTextView;
//        private TextView spaouseNameTextView;
//        private TextView membershipNoTextView;
//        private TextView memberSinceTextView;
//        private TextView bloodGroupTextView;
//        private TextView districtPositionTextView;
//        private TextView cellTextView;
//        private TextView emailTextView;
//        private ImageView memberImage;
//        private ImageView spaouseImage;
//
//        private ImageView callButton;
//        private ImageView emailButton;
//        private ImageView textButton;
//
//        public MemberViewHolder(@NonNull View itemView) {
//            super(itemView);
//            nameTextView = itemView.findViewById(R.id.name);
//            clubPositionTextView = itemView.findViewById(R.id.clubPosition);
//            callButton = itemView.findViewById(R.id.call);
//            emailButton = itemView.findViewById(R.id.mail);
//            textButton = itemView.findViewById(R.id.massage);
//            address1TextView = itemView.findViewById(R.id.address1);
//            address2TextView = itemView.findViewById(R.id.address2);
//            emailTextView = itemView.findViewById(R.id.email);
//            phoneTextView = itemView.findViewById(R.id.phone);
//            cellTextView = itemView.findViewById(R.id.cell);
//            spaouseNameTextView = itemView.findViewById(R.id.spouseName);
//            membershipNoTextView = itemView.findViewById(R.id.membershipNo);
//            memberSinceTextView = itemView.findViewById(R.id.memberSince);
//            bloodGroupTextView = itemView.findViewById(R.id.bloodGroup);
//            districtPositionTextView = itemView.findViewById(R.id.districtPosition);
//            memberImage = itemView.findViewById(R.id.memberImage);
//            spaouseImage = itemView.findViewById(R.id.spouseImage);
//
//        }
//    }
//
