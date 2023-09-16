// Generated by view binder compiler. Do not edit!
package com.example.gerenciadorcompromissos.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gerenciadorcompromissos.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnAdd;

  @NonNull
  public final RecyclerView rcvCompromissos;

  @NonNull
  public final TextView txtIntro;

  private ActivityMainBinding(@NonNull LinearLayout rootView, @NonNull Button btnAdd,
      @NonNull RecyclerView rcvCompromissos, @NonNull TextView txtIntro) {
    this.rootView = rootView;
    this.btnAdd = btnAdd;
    this.rcvCompromissos = rcvCompromissos;
    this.txtIntro = txtIntro;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAdd;
      Button btnAdd = ViewBindings.findChildViewById(rootView, id);
      if (btnAdd == null) {
        break missingId;
      }

      id = R.id.rcvCompromissos;
      RecyclerView rcvCompromissos = ViewBindings.findChildViewById(rootView, id);
      if (rcvCompromissos == null) {
        break missingId;
      }

      id = R.id.txtIntro;
      TextView txtIntro = ViewBindings.findChildViewById(rootView, id);
      if (txtIntro == null) {
        break missingId;
      }

      return new ActivityMainBinding((LinearLayout) rootView, btnAdd, rcvCompromissos, txtIntro);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
