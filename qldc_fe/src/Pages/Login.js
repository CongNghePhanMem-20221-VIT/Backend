import React, { useState } from "react";
import { useForm } from "react-hook-form"

const Login = () => {
    const { register, handleSubmit, formState: { errors } } = useForm()
    const [typePass, setTypePass] = useState(false)
    const onSubmit = (data) => {
        console.log(data)
    }

    return (
        <div className="login">
            <form className="login_form"
                onSubmit={handleSubmit(onSubmit)}
            >
                <h2>Đăng nhập</h2>
                <div className="login_item">
                    <strong htmlFor="Name">Username:</strong>
                    <input
                        {...register('name', { required: true, minLength: { value: 6, message: 'Vui lòng nhập tên đăng nhập!' } })}
                    />
                </div>
                <div className="login_item">
                    <strong htmlFor="password">Password:</strong>
                    <input
                        {...register('password', { required: true, minLength: { value: 6, message: "Vui lòng nhập mật khẩu" } })}
                        type={typePass ? 'text' : 'password'}
                    >

                    </input>
                    <small onClick={() => setTypePass(!typePass)}>
                        {typePass ? 'Hide' : 'Show'}
                    </small>
                </div>
                <button type="submit" className="button_disabled">Log In</button>
            </form >
        </div >
    )
}

export default Login 