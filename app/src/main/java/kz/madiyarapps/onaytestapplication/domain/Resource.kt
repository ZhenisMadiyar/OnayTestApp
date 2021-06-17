package kz.madiyarapps.onaytestapplication.domain

class Resource<T> private constructor(
    val state: State,
    val baseData: T?,
    val error: Throwable?
) {

    enum class State {
        LOADING,
        SUCCESS,
        ERROR
    }


    companion object {
        fun<T> loading(): Resource<T> =
            Resource(
                State.LOADING,
                null,
                null
            )

        fun<T> success(data: T): Resource<T> =
            Resource(
                State.SUCCESS,
                data,
                null
            )

        fun<T> error(error: Throwable?): Resource<T> =
            Resource(
                State.ERROR,
                null,
                error
            )
    }

}