package com.aj.article_module.bean

import android.os.Parcel
import android.os.Parcelable

/**
 *
 * @Package:        com.aj.article_module.bean
 * @ClassName:      SystemTreeChildren
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/8/19 10:45
 */
data class SystemTreeChildren(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String?,
    val order: Int,
    val parentChapterId: Int,
    val visible: Int
) : Parcelable {
    constructor(source: Parcel) : this(
        ArrayList<Any>().apply { source.readList(this as List<*>, Any::class.java.classLoader) },
        source.readInt(),
        source.readInt(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeList(children)
        writeInt(courseId)
        writeInt(id)
        writeString(name)
        writeInt(order)
        writeInt(parentChapterId)
        writeInt(visible)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SystemTreeChildren> =
            object : Parcelable.Creator<SystemTreeChildren> {
                override fun createFromParcel(source: Parcel): SystemTreeChildren =
                    SystemTreeChildren(source)

                override fun newArray(size: Int): Array<SystemTreeChildren?> = arrayOfNulls(size)
            }
    }
}