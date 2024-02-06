package com.example.linkanotherpage.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.linkanotherpage.R;
import com.example.linkanotherpage.model.ClubModel;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.MemberViewHolder> {

    private List<ClubModel> memberList;
    private Context context;
    private List<ClubModel> filteredMemberList;


    public ClubAdapter(List<ClubModel> memberList, Context context) {
        this.memberList = memberList;
        this.context = context;
        this.filteredMemberList = new ArrayList<>(memberList);
    }

    @NonNull
    @Override
    public ClubAdapter.MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.member_detils, parent, false);

        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubAdapter.MemberViewHolder holder, int position) {


        ClubModel member = filteredMemberList.get(position);
        holder.bind(member);


    }

    @Override
    public int getItemCount() {
        return memberList.size();
    }

    public void filterList(String query) {
        filteredMemberList.clear();

        for (ClubModel member : memberList) {
            if (containsQueryInAttributes(member, query)) {
                filteredMemberList.add(member);
            }
        }

        notifyDataSetChanged();
    }

    private boolean containsQueryInAttributes(ClubModel member, String query) {
        // Check specific attributes that you want to search
        String[] attributesToSearch = {
                member.getName(),
                member.getClubPosition(),
                member.getAddress1(),
                member.getAddress2(),
                member.getEmail(),
                member.getBloodGroup()
                // Add more attributes as needed
        };

        for (String attribute : attributesToSearch) {
            if (attribute != null && attribute.toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    static class MemberViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView clubPositionTextView;
        private TextView address1TextView;
        private TextView address2TextView;
        private TextView phoneTextView;
        private TextView spaouseNameTextView;
        private TextView membershipNoTextView;
        private TextView memberSinceTextView;
        private TextView bloodGroupTextView;
        private TextView districtPositionTextView;
        private TextView cellTextView;
        private TextView emailTextView;
        private ImageView memberImage;
        private ImageView spaouseImage;

        private ImageView callButton;
        private ImageView emailButton;
        private ImageView textButton;

        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name);
            clubPositionTextView = itemView.findViewById(R.id.clubPosition);
            callButton = itemView.findViewById(R.id.call);
            emailButton = itemView.findViewById(R.id.mail);
            textButton = itemView.findViewById(R.id.massage);
            address1TextView = itemView.findViewById(R.id.address1);
            address2TextView = itemView.findViewById(R.id.address2);
            emailTextView = itemView.findViewById(R.id.email);
            phoneTextView = itemView.findViewById(R.id.phone);
            cellTextView = itemView.findViewById(R.id.cell);
            spaouseNameTextView = itemView.findViewById(R.id.spouseName);
            membershipNoTextView = itemView.findViewById(R.id.membershipNo);
            memberSinceTextView = itemView.findViewById(R.id.memberSince);
            bloodGroupTextView = itemView.findViewById(R.id.bloodGroup);
            districtPositionTextView = itemView.findViewById(R.id.districtPosition);
            memberImage = itemView.findViewById(R.id.memberImage);
            spaouseImage = itemView.findViewById(R.id.spouseImage);

        }


        public void bind(ClubModel member) {

            nameTextView.setText("Name: " + member.getName());
            clubPositionTextView.setText("Club Position: " + member.getClubPosition());
            address1TextView.setText("Address 1: " + member.getAddress1());
            address2TextView.setText("Address 2: " + member.getAddress2());
            emailTextView.setText("Email: " + member.getEmail());
            phoneTextView.setText("Phone: " + member.getPhone());
            cellTextView.setText("Cell: " + member.getCell());
            spaouseNameTextView.setText("Spaouse Name: " + member.getSpouseName());
            membershipNoTextView.setText("Membership No: " + member.getMembershipNo());
            memberSinceTextView.setText("Member Since " + member.getMemberSince());
            bloodGroupTextView.setText("Blood Group:  " + member.getBloodGroup());
            districtPositionTextView.setText("District Position: " + member.getDistrictPosition());


            String relativeImagePathmember = member.getMemberImage();
            String baseUrlmember = "https://purbachal.emranhss.com/";
            String imageUrlmember = baseUrlmember + relativeImagePathmember;

            String relativeImagePathspaous = member.getSpouseImage();
            String baseUrlspaous = "https://purbachal.emranhss.com/";
            String imageUrlspaous = baseUrlspaous + relativeImagePathspaous;

            Picasso.get().load(imageUrlspaous).into(spaouseImage);
            Picasso.get().load(imageUrlmember).into(memberImage);


            // Set up button click listeners
            callButton.setOnClickListener(v -> {
                try {
                    makeCall(member.getCell());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            emailButton.setOnClickListener(v -> {
                if (member != null) {
                    sendEmail(member.getEmail());
                }
            });

            textButton.setOnClickListener(v -> {
                if (member != null) {
                    makeSMS(member.getCell());
                }
            });
        }


        private void makeCall(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            itemView.getContext().startActivity(intent);
        }

        private void makeSMS(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:" + phoneNumber));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            itemView.getContext().startActivity(intent);
        }

        private void sendEmail(String emailAddress) {
            // Implement logic to send an email
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + emailAddress));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            itemView.getContext().startActivity(intent);
        }


    }


}
