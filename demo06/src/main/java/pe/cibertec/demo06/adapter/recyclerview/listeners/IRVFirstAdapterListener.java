package pe.cibertec.demo06.adapter.recyclerview.listeners;

import pe.cibertec.demo06.entities.Persona;

/**
 * Created by Android-SAB-PM on 30/04/2016.
 */
public interface IRVFirstAdapterListener {
    void onItemClick(Persona persona);
    void onItemMapClick(Persona persona);
    void onItemPhoneClick(Persona persona);
}
