package method.exampleapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import method.exampleapplication.responseModels.InstaResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class InstaListFragment extends Fragment {
    private InstaResponse instaResponse;


    @BindView(R.id.rv)
    RecyclerView rv;


    public InstaListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insta_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        final Gson gson = new Gson();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url("https://api.instagram.com/v1/users/275855784/media/recent/?access_token=275855784.1677ed0.4da1ffa33669461d819cf0ae595fc537")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {}

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseString = response.body().string(); // "{asdasdk...}"
                instaResponse = gson.fromJson(responseString,InstaResponse.class);
                fillPost(instaResponse);
            }
        });

    }

    private void fillPost(final InstaResponse response) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                rv.setLayoutManager(new LinearLayoutManager(getContext()));
                instaAdapter adapter = new instaAdapter();
                adapter.setInstaList(response.getData());
                rv.setAdapter(adapter);
            }
        });
    }
}
