//
//  MenuCVCell.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 13.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit


protocol MenuItemDelegate {
    func onMenuItemClick()
}


class MenuCVCell: UICollectionViewCell {

    @IBOutlet weak var imageView: UIImageView! {
        didSet {
            imageView.image = #imageLiteral(resourceName: "logoIcon")
        }
    }
    @IBOutlet weak var descriptionLabel: UILabel!
    
    var delegate: MenuItemDelegate?
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    func setGesture() {
        let tapGesture = UITapGestureRecognizer(target: self, action: #selector(onClick))
        self.addGestureRecognizer(tapGesture)
        self.isUserInteractionEnabled = true
    }
    
    func onClick() {
        delegate?.onMenuItemClick()
        RequestManager.getUsers()
    }
    
    func setModel(_ model: MenuItemModel) {
        imageView.image = model.image
        descriptionLabel.text = model.description
    }

}
