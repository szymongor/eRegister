//
//  FormVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 14.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class FormVC: UIViewController {

    @IBOutlet weak var titleLabel: UILabel! {
        didSet {
            titleLabel.textColor = Colors.MAIN
        }
    }
    @IBOutlet weak var oldValueTF: UITextField! {
        didSet {
            oldValueTF.appTheme()
        }
    }
    @IBOutlet weak var newValueTF: UITextField! {
        didSet {
            newValueTF.appTheme()
        }
    }
    @IBOutlet weak var confirmNewValueTF: UITextField! {
        didSet {
            confirmNewValueTF.appTheme()
        }
    }
    @IBOutlet weak var confirmButton: UIButton! {
        didSet {
            confirmButton.appTheme()
            confirmButton.setTitle("Potwierdź", for: .normal)
        }
    }
    
    var type: SettingType = .password
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
}


// MARK: - Form preparation using type

extension FormVC {
    
    func setType(_ type: SettingType) {
        self.type = type
        prepareForm(using: type)
    }
    
    private func prepareForm(using type: SettingType) {
        switch type {
        case .password:
            prepareAsPasswordForm()
        case .phone:
            prepareAsPhoneForm()
        case .email:
            prepareAsEmailForm()
        case .address:
            prepareAsAddressForm()
        }
    }
    
    private func prepareAsPasswordForm() {
        self.title = "Hasło"
        
        titleLabel.isHidden = false
        let passwordLength = User.instance.password.characters.count
        titleLabel.text = String(repeating: "*", count: passwordLength)
        oldValueTF.placeholder = "Stare hasło"
        oldValueTF.isSecureTextEntry = true
        newValueTF.placeholder = "Nowe hasło"
        newValueTF.isSecureTextEntry = true
        confirmNewValueTF.placeholder = "Powtórz hasło"
        confirmNewValueTF.isSecureTextEntry = true
        confirmButton.addTarget(self, action: #selector(changePassword), for: .touchUpInside)
    }
    
    private func prepareAsPhoneForm() {
        self.title = "Telefon"
        
        titleLabel.isHidden = false
        titleLabel.text = User.instance.phone
        oldValueTF.isHidden = true
        newValueTF.placeholder = "Nowy numer"
        newValueTF.keyboardType = .phonePad
        confirmNewValueTF.placeholder = "Hasło"
        confirmNewValueTF.isSecureTextEntry = true
        confirmButton.addTarget(self, action: #selector(changePhone), for: .touchUpInside)
    }
    
    private func prepareAsEmailForm() {
        self.title = "E-mail"
        
        titleLabel.isHidden = false
        titleLabel.text = User.instance.mail
        oldValueTF.isHidden = true
        newValueTF.placeholder = "Nowy e-mail"
        newValueTF.keyboardType = .emailAddress
        confirmNewValueTF.placeholder = "Hasło"
        confirmNewValueTF.isSecureTextEntry = true
        confirmButton.addTarget(self, action: #selector(changeMail), for: .touchUpInside)
    }
    
    private func prepareAsAddressForm() {
        self.title = "Adres"
        
        self.oldValueTF.isHidden = true
        self.newValueTF.isHidden = true
        self.confirmNewValueTF.isHidden = true
        self.confirmButton.isHidden = true
        
        RequestManager.getAddress(byId: User.instance.id, completion: {
            success, address in
            
            self.titleLabel.isHidden = false
            guard let addressObj = address else {
                return
            }
            var flatNumber = ""
            if let flat = addressObj.flatNumber {
                flatNumber = "/\(flat)"
            } else {
                flatNumber = ""
            }
            self.titleLabel.text = "\(addressObj.country), \(addressObj.city)\n ul. \(addressObj.street) \(addressObj.houseNumber)\(flatNumber)\n \(addressObj.postalCode)"
            
        })
    }

}

extension FormVC {
    func changePassword() {
        print("Password change, new password: \(newValueTF.text)")
        guard let old = oldValueTF.text else {
            return
        }
        guard let new = newValueTF.text else {
            return
        }
        RequestManager.changePassword(oldPassword: old, newPassword: new, completion: {
            success in
            
            self.navigationController?.popViewController(animated: true)
        })
        RequestManager.getPerson(byId: User.instance.id, completion: {
            success in
            print("Person fetching: \(success)")
        })
    }
    
    func changePhone() {
        print("Phone change, new phone: \(newValueTF.text)")
        guard let old = oldValueTF.text else {
            return
        }
        guard let new = newValueTF.text else {
            return
        }
        RequestManager.changePhone(for: User.instance.id, newPhone: new, completion: {
            success in
            
            self.navigationController?.popViewController(animated: true)
        })
        RequestManager.getPerson(byId: User.instance.id, completion: {
            success in
            print("Person fetching: \(success)")
        })
    }
    
    func changeMail() {
        print("Mail change, new mail: \(newValueTF.text)")
        guard let old = oldValueTF.text else {
            return
        }
        guard let new = newValueTF.text else {
            return
        }
        RequestManager.changeMail(for: User.instance.id, newMail: new, completion: {
            success in
            
            self.navigationController?.popViewController(animated: true)
        })
        RequestManager.getPerson(byId: User.instance.id, completion: {
            success in
            print("Person fetching: \(success)")
        })
    }
}
