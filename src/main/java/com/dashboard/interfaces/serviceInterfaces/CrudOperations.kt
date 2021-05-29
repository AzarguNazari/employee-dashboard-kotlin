package dashboard.interfaces.serviceInterfaces

interface CrudOperations<T> {
    fun save(`object`: T)
    fun delete(id: Int)
    fun update(id: Int, `object`: T)
    fun exist(id: Int): Boolean
    fun all(): List<T>?
    fun getById(id: Int): T
}