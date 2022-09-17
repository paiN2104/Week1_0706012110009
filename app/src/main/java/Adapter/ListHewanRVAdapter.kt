package Adapter

import Database.GlobalVar
import Interface.CardListener
import Model.Hewan
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.component1
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.CreateActivity
import com.example.week1.HomeActivity
import com.example.week1.R
import com.example.week1.databinding.ActivityHomeBinding
import com.example.week1.databinding.CardviewBinding

class ListHewanRVAdapter(val listHewan : ArrayList<Hewan>, val cardListener: CardListener):
RecyclerView.Adapter<ListHewanRVAdapter.viewHolder>() {
    class viewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding = CardviewBinding.bind(itemView)

        fun setData(data: Hewan) {
            binding.nameCard.text = data.nama
            binding.typeCard.text = data.jenis
            binding.usiaCard.text = " : "+data.usia+" Tahun"

            if (!data.imageUri!!.isEmpty()) {
                binding.imageView3.setImageURI(Uri.parse(data.imageUri))
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.cardview,parent,false)
        return viewHolder(view)
    }
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.setData(listHewan[position])
        holder.binding.deleteButton.setOnClickListener{
            GlobalVar.listDataHewan.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(it.context, "Hewan Berhasil Dihapus", Toast.LENGTH_SHORT).show()
        }
        holder.binding.editButton.setOnClickListener{
            val myIntent= Intent(it.context,CreateActivity::class.java).putExtra(
                "position",position
            )
            it.context.startActivity(myIntent)
        }
    }

    override fun getItemCount(): Int {
        return listHewan.size
    }

}