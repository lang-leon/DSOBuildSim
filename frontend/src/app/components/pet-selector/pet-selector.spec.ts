import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PetSelector } from './pet-selector';

describe('PetSelector', () => {
  let component: PetSelector;
  let fixture: ComponentFixture<PetSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PetSelector],
    }).compileComponents();

    fixture = TestBed.createComponent(PetSelector);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
