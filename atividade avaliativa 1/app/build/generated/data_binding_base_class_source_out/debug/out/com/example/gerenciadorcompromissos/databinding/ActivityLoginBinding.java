// Generated by view binder compiler. Do not edit!
package com.example.gerenciadorcompromissos.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.gerenciadorcompromissos.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnEntrar;

  @NonNull
  public final Button btnPrimeiroAcesso;

  @NonNull
  public final EditText edtEmail;

  @NonNull
  public final EditText edtSenha;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  private ActivityLoginBinding(@NonNull LinearLayout rootView, @NonNull Button btnEntrar,
      @NonNull Button btnPrimeiroAcesso, @NonNull EditText edtEmail, @NonNull EditText edtSenha,
      @NonNull TextView textView, @NonNull TextView textView2) {
    this.rootView = rootView;
    this.btnEntrar = btnEntrar;
    this.btnPrimeiroAcesso = btnPrimeiroAcesso;
    this.edtEmail = edtEmail;
    this.edtSenha = edtSenha;
    this.textView = textView;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnEntrar;
      Button btnEntrar = ViewBindings.findChildViewById(rootView, id);
      if (btnEntrar == null) {
        break missingId;
      }

      id = R.id.btnPrimeiroAcesso;
      Button btnPrimeiroAcesso = ViewBindings.findChildViewById(rootView, id);
      if (btnPrimeiroAcesso == null) {
        break missingId;
      }

      id = R.id.edtEmail;
      EditText edtEmail = ViewBindings.findChildViewById(rootView, id);
      if (edtEmail == null) {
        break missingId;
      }

      id = R.id.edtSenha;
      EditText edtSenha = ViewBindings.findChildViewById(rootView, id);
      if (edtSenha == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new ActivityLoginBinding((LinearLayout) rootView, btnEntrar, btnPrimeiroAcesso,
          edtEmail, edtSenha, textView, textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
