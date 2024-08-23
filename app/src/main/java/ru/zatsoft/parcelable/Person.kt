package ru.zatsoft.parcelable

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


//@Parcelize
data class Person( val name: String?, val lastName: String?, val address: String?, val telephone: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int {
     return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(lastName)
        dest.writeString(address)
        dest.writeString(telephone)
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}
