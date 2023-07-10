package com.bone.browser;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.SearchView;

public class MainActivity extends Activity {
    private WebView webView;
    private SearchView searchView;
    private ImageView bookmark, addnewtab, menu;
    private String currentUrl = "https://www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        searchView = findViewById(R.id.searchbar);
        bookmark = findViewById(R.id.bookmark);
        addnewtab = findViewById(R.id.addnewtab);
        menu = findViewById(R.id.menu);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        webView.loadUrl(currentUrl);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle bookmark click event
            }
        });

        addnewtab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle new tab click event
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle menu click event
            }
        });
    }

    private void performSearch(String searchText) {
        if (!searchText.isEmpty()) {
            String searchUrl = "https://www.google.com/search?q=" + searchText;
            webView.loadUrl(searchUrl);
            webView.setVisibility(View.VISIBLE);
            currentUrl = searchUrl;
        }
    }
}
