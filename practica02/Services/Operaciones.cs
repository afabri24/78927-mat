using System;
using WSDL.mensajes;

namespace WSDL.operaciones
{
    public class Operaciones : Mensajes
    {
        List<string> saludos = new List<string>();
        public string Saludar(string nombre)
        {
            string msj= "Hola " + nombre;
            saludos.Add(nombre);
            return msj;
        }

        public string Mostrar(int id)
        {
            if (id > saludos.Count)
                return "No existe el saludo";
            else
            return saludos[id-1];
        }
    }
}