package Database

import Model.Hewan

class GlobalVar {

    companion object{
        val STORAGE_PERMISSION_CODE: Int=100
        val READ_EXTERNAL_STORAGE: Int = 100
        val listDataHewan = ArrayList<Hewan>()
    }
}