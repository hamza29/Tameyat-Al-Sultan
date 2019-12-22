package com.glowingsoft.tameyatalsultan.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.glowingsoft.tameyatalsultan.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MenuFragment extends Fragment {
    RecyclerView recyclerView, recyclerView1;
    SlimAdapter slimAdapter, slimAdapter1;
    ArrayList<NewModel> arrayList = new ArrayList<>();
    ArrayList<NewModelcate> arrayList1 = new ArrayList<>();


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
//First Recycler View
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView1 = view.findViewById(R.id.recycler_view1);
        arrayList.add(new NewModel("Thokar", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        arrayList.add(new NewModel("Gulberg", "helo", "", "", "", "", "", ""));
        LinearLayoutManager lLayout = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lLayout);

        slimAdapter = SlimAdapter.create()
                .register(R.layout.card_view_history, new SlimInjector<NewModel>() {
                    @Override
                    public void onInject(final NewModel data, IViewInjector injector) {
//                        injector.text(R.id.driver_name, data.getStock());
//                        injector.text(R.id.rt_st, data.getRotStart());
//                        injector.text(R.id.rt_en, data.getRotEnd());
//                        injector.text(R.id.dr_en, data.getDrContact());
//                        injector.text(R.id.stops, data.getPathlist());


                    }
                })

                .attachTo(recyclerView).updateData(arrayList);

//Second Recycler View


        arrayList1.add(new NewModelcate("Pizza", "helo", "", "", "", "", "", ""));
        arrayList1.add(new NewModelcate("Sandwich", "helo", "", "", "", "", "", ""));
        arrayList1.add(new NewModelcate("Burger", "helo", "", "", "", "", "", ""));
        arrayList1.add(new NewModelcate("Roast", "helo", "", "", "", "", "", ""));
        LinearLayoutManager lLayout1 = new LinearLayoutManager(getActivity());
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(lLayout1);

        slimAdapter1 = SlimAdapter.create()
                .register(R.layout.card_view_history, new SlimInjector<NewModelcate>() {
                    @Override
                    public void onInject(final NewModelcate data, IViewInjector injector) {
//                        injector.text(R.id.driver_name, data.getStock());
//                        injector.text(R.id.rt_st, data.getRotStart());
//                        injector.text(R.id.rt_en, data.getRotEnd());
//                        injector.text(R.id.dr_en, data.getDrContact());
//                        injector.text(R.id.stops, data.getPathlist());


                    }
                })

                .attachTo(recyclerView1).updateData(arrayList1);


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public class NewModel {

        String stock;
        String point;
        String lat_bus;
        String lng_bus;
        String lat_origin;
        String lng_origin;
        String lat_destination;
        String lng_destination;

        public NewModel() {
        }

        public NewModel(String stock, String point, String lat_bus, String lng_bus, String lat_origin, String lng_origin, String lat_destination, String lng_destination) {

            this.stock = stock;
            this.point = point;
            this.lat_bus = lat_bus;
            this.lng_bus = lng_bus;
            this.lat_origin = lat_origin;
            this.lng_origin = lng_origin;
            this.lat_destination = lat_destination;
            this.lng_destination = lng_destination;
        }

        public String getLat_origin() {
            return lat_origin;
        }

        public void setLat_origin(String lat_origin) {
            this.lat_origin = lat_origin;
        }

        public String getLng_origin() {
            return lng_origin;
        }

        public void setLng_origin(String lng_origin) {
            this.lng_origin = lng_origin;
        }

        public String getLat_destination() {
            return lat_destination;
        }

        public void setLat_destination(String lat_destination) {
            this.lat_destination = lat_destination;
        }

        public String getLng_destination() {
            return lng_destination;
        }

        public void setLng_destination(String lng_destination) {
            this.lng_destination = lng_destination;
        }

        public String getLng_bus() {
            return lng_bus;
        }

        public void setLng_bus(String lng_bus) {
            this.lng_bus = lng_bus;
        }

        public String getLat_bus() {
            return lat_bus;
        }

        public void setLat_bus(String lat_bus) {
            this.lat_bus = lat_bus;
        }


        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }


    }

    public class NewModelcate {

        String stock;
        String point;
        String lat_bus;
        String lng_bus;
        String lat_origin;
        String lng_origin;
        String lat_destination;
        String lng_destination;

        public NewModelcate() {
        }

        public NewModelcate(String stock, String point, String lat_bus, String lng_bus, String lat_origin, String lng_origin, String lat_destination, String lng_destination) {

            this.stock = stock;
            this.point = point;
            this.lat_bus = lat_bus;
            this.lng_bus = lng_bus;
            this.lat_origin = lat_origin;
            this.lng_origin = lng_origin;
            this.lat_destination = lat_destination;
            this.lng_destination = lng_destination;
        }

        public String getLat_origin() {
            return lat_origin;
        }

        public void setLat_origin(String lat_origin) {
            this.lat_origin = lat_origin;
        }

        public String getLng_origin() {
            return lng_origin;
        }

        public void setLng_origin(String lng_origin) {
            this.lng_origin = lng_origin;
        }

        public String getLat_destination() {
            return lat_destination;
        }

        public void setLat_destination(String lat_destination) {
            this.lat_destination = lat_destination;
        }

        public String getLng_destination() {
            return lng_destination;
        }

        public void setLng_destination(String lng_destination) {
            this.lng_destination = lng_destination;
        }

        public String getLng_bus() {
            return lng_bus;
        }

        public void setLng_bus(String lng_bus) {
            this.lng_bus = lng_bus;
        }

        public String getLat_bus() {
            return lat_bus;
        }

        public void setLat_bus(String lat_bus) {
            this.lat_bus = lat_bus;
        }


        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }


    }

}
