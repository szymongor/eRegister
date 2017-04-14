//
//  MenuCVCell.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 13.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class MenuCVCell: UICollectionViewCell {

    @IBOutlet weak var imageView: UIImageView!
    @IBOutlet weak var descriptionLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    func setModel(_ model: MenuItemModel) {
        imageView.image = model.image
        descriptionLabel.text = model.description
    }

}
